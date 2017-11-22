package org.crysil.actor.softwarecrypto;

import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.List;

import org.crysil.errorhandling.InvalidCertificateException;
import org.crysil.errorhandling.KeyNotFoundException;
import org.crysil.protocol.payload.crypto.key.Key;
import org.crysil.protocol.payload.crypto.key.KeyHandle;

public interface SoftwareCryptoKeyStore {

	public java.security.Key getJCEPrivateKey(Key decryptionKey) throws KeyNotFoundException;

	public X509Certificate getX509Certificate(KeyHandle keyHandle);

	public PublicKey getJCEPublicKey(Key currentKey) throws InvalidCertificateException, KeyNotFoundException;

	public List<KeyHandle> getKeyList();

}