package objects;

import pkcs11.PKCS11Error;

import java.util.ArrayList;

import obj.CK_ATTRIBUTE;
import obj.CK_RETURN_TYPE;


public class ObjectManager {

	private ArrayList<PKCS11Object> objects = new ArrayList<>();
	private ArrayList<Long> ids = new ArrayList<>();

	synchronized public ArrayList<Long> findObjects(CK_ATTRIBUTE[] template) throws PKCS11Error {
		ArrayList<Long> result = new ArrayList<>();
		for (PKCS11Object tmp : objects) {
			if (tmp.query(template)) {
				result.add(ids.get(objects.indexOf(tmp)));
			}
		}
		return result;
	}
	synchronized public PKCS11Object getObject(long id) throws PKCS11Error {
		for (Long tmp : ids) {
			if (tmp == id) {
				int index = ids.indexOf(tmp);
				return objects.get(index);
			}
		}
		throw new PKCS11Error(CK_RETURN_TYPE.CKR_OBJECT_HANDLE_INVALID);
	}

	synchronized public long createObject(CK_ATTRIBUTE[] template) throws PKCS11Error {
		Long id = getNextId();
		PKCS11Object object = ObjectBuilder.createFromTemplate(template);
		objects.add(object);
		ids.add(id);
		return id;
	}

	synchronized public long addObject(PKCS11Object object) throws PKCS11Error {
		if(object == null){
			throw new PKCS11Error(CK_RETURN_TYPE.CKR_OBJECT_HANDLE_INVALID);
		}
		if(objects.contains(object)){
			return ids.get(objects.indexOf(object));
		}
		Long id = getNextId();
		objects.add(object);
		ids.add(id);
		return id;
	}

	synchronized public void deleteObject(long id) throws PKCS11Error {
		for (Long tmp : ids) {
			if (tmp == id) {
				int index = ids.indexOf(tmp);
				ids.remove(index);
				objects.remove(index);
				return;
			}
		}
		throw new PKCS11Error(CK_RETURN_TYPE.CKR_OBJECT_HANDLE_INVALID);
	}

	private Long getNextId() {
		Long id = 0L;
		for (Long tmp : ids) {
			if (tmp > id) {
				id = tmp;
			}
		}
		id++;
		return id;
	}
	public long newObject(byte[] unwrappedKey, CK_ATTRIBUTE[] pTemplate) {
		Long id=getNextId();
	
		PKCS11Object object = new PKCS11Object(pTemplate, unwrappedKey, true);
		objects.add(object);
		ids.add(id);
		return id;
	}
}
