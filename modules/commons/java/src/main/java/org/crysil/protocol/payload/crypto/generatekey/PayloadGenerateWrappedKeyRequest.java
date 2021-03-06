package org.crysil.protocol.payload.crypto.generatekey;

import java.util.ArrayList;
import java.util.List;

import org.crysil.logging.Logger;
import org.crysil.protocol.payload.PayloadRequest;
import org.crysil.protocol.payload.crypto.PayloadWithKey;
import org.crysil.protocol.payload.crypto.key.Key;

/**
 * Request for generating a key following some specifications but return a wrapped (i.e. encrypted) representation of the key.
 * Only the service that has the wrapping key (encrypting key) can use the key itself.
 */
public class PayloadGenerateWrappedKeyRequest extends PayloadRequest implements PayloadWithKey {

	/** The key type. */
	protected String keyType;

	/** The encryption keys. */
	protected List<Key> encryptionKeys = new ArrayList<>();

	/** The signing key. */
	protected Key signingKey;

	/** The certificate subject. */
	protected String certificateSubject;

	/**
	 * Gets the key type.
	 *
	 * @return the key type
	 */
	public String getKeyType() {
		return keyType;
	}

	/**
	 * Sets the key type.
	 *
	 * @param keyType
	 *            the new key type
	 */
	public void setKeyType(String keyType) {
		this.keyType = keyType;
	}

	/**
	 * Gets the encryption keys.
	 *
	 * @return the encryption keys
	 */
	public List<Key> getEncryptionKeys() {
		return encryptionKeys;
	}

	/**
	 * Sets the encryption keys.
	 *
	 * @param encryptionKeys
	 *            the new encryption keys
	 */
	public void setEncryptionKeys(List<Key> encryptionKeys) {
		clearEncryptionKeys();

		for (Key current : encryptionKeys)
			addEncryptionKey(current);
	}

	/**
	 * clear the list of encryption keys
	 */
	public void clearEncryptionKeys() {
		encryptionKeys.clear();
	}

	/**
	 * add another encryption key to the list
	 * 
	 * @param encryptionKey
	 */
	public void addEncryptionKey(Key encryptionKey) {
		this.encryptionKeys.add(encryptionKey);
	}

	/**
	 * Gets the signing key.
	 *
	 * @return the signing key
	 */
	public Key getSigningKey() {
		return signingKey;
	}

	/**
	 * Sets the signing key.
	 *
	 * @param signingKey
	 *            the new signing key
	 */
	public void setSigningKey(Key signingKey) {
		this.signingKey = signingKey;
	}

	/**
	 * Gets the certificate subject.
	 *
	 * @return the certificate subject
	 */
	public String getCertificateSubject() {
		return certificateSubject;
	}

	/**
	 * Sets the certificate subject.
	 *
	 * @param certificateSubject
	 *            the new certificate subject
	 */
	public void setCertificateSubject(String certificateSubject) {
		this.certificateSubject = certificateSubject;
	}

	@Override
	public String getType() {
		return "generateWrappedKeyRequest";
	}

	@Override
	public List<Key> getKeys() {
		return getEncryptionKeys();
	}

	@Override
	public PayloadRequest getBlankedClone() {
		PayloadGenerateWrappedKeyRequest result = new PayloadGenerateWrappedKeyRequest();
		result.keyType = Logger.isDebugEnabled() ? keyType : "*****";
		List<Key> keys = new ArrayList<>();
		for (Key current : encryptionKeys)
			keys.add(current.getBlankedClone());
		result.encryptionKeys = keys;
		if (null != signingKey)
			result.signingKey = signingKey.getBlankedClone();
		else
			result.signingKey = null;
		result.certificateSubject = Logger.isDebugEnabled() ? certificateSubject : "*****";

		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((certificateSubject == null) ? 0 : certificateSubject.hashCode());
		result = prime * result + ((encryptionKeys == null) ? 0 : encryptionKeys.hashCode());
		result = prime * result + ((keyType == null) ? 0 : keyType.hashCode());
		result = prime * result + ((signingKey == null) ? 0 : signingKey.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PayloadGenerateWrappedKeyRequest other = (PayloadGenerateWrappedKeyRequest) obj;
		if (certificateSubject == null) {
			if (other.certificateSubject != null)
				return false;
		} else if (!certificateSubject.equals(other.certificateSubject))
			return false;
		if (encryptionKeys == null) {
			if (other.encryptionKeys != null)
				return false;
		} else if (!encryptionKeys.equals(other.encryptionKeys))
			return false;
		if (keyType == null) {
			if (other.keyType != null)
				return false;
		} else if (!keyType.equals(other.keyType))
			return false;
		if (signingKey == null) {
			if (other.signingKey != null)
				return false;
		} else if (!signingKey.equals(other.signingKey))
			return false;
		return true;
	}
}
