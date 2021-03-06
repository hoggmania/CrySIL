package org.crysil.protocol.payload.auth.debugnoauth;

import java.util.Arrays;

import org.crysil.protocol.payload.auth.AuthInfo;

/**
 * {@link AuthInfo} implementation of a username/password tuple.
 */
public class DebugNoAuthInfo extends AuthInfo {

  @Override
  public String getType() {
    return "DebugNoAuthInfo";
  }

  @Override
  public AuthInfo getBlankedClone() {
    final DebugNoAuthInfo result = new DebugNoAuthInfo();

    return result;
  }
  @Override
  public int hashCode() {
   return Arrays.hashCode(new Object[]{type});
  }
}
