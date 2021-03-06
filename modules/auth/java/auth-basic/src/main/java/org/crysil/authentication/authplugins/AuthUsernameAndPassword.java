package org.crysil.authentication.authplugins;

import java.awt.EventQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

import org.crysil.authentication.AuthException;
import org.crysil.authentication.AuthHandler;
import org.crysil.authentication.AuthHandlerFactory;
import org.crysil.authentication.ui.ActionPerformedCallback;
import org.crysil.authentication.ui.IAuthUI;
import org.crysil.authentication.ui.UsernameAndPasswordDialog;
import org.crysil.protocol.Response;
import org.crysil.protocol.payload.auth.AuthInfo;
import org.crysil.protocol.payload.auth.AuthType;
import org.crysil.protocol.payload.auth.credentials.UserPasswordAuthInfo;
import org.crysil.protocol.payload.auth.credentials.UserPasswordAuthType;

public class AuthUsernameAndPassword<T extends IAuthUI<char[][], Void>> implements AuthHandler {
  private final Class<T> dialogType;

  public static class Factory<T extends IAuthUI<char[][], Void>>
      implements AuthHandlerFactory<char[][], Void, T> {

    private final Class<T> dialogType;

    public Factory(final Class<T> dialogType) {
      this.dialogType = dialogType;
    }

    @Override
    public AuthHandler createInstance(final Response crysilResponse, final AuthType authType,
        final Class<T> dialogType) throws AuthException {
      if (!canTake(crysilResponse, authType)) {
        throw new AuthException("Invalid authType");
      }

      return new AuthUsernameAndPassword<>(dialogType);
    }

    @Override
    public boolean canTake(final Response crysilResponse, final AuthType authType) throws AuthException {
      return (authType instanceof UserPasswordAuthType);
    }

    @Override
    public Class<T> getDialogType() {
      return dialogType;
    }
  }

  public AuthUsernameAndPassword(final Class<T> dialogType) {
    this.dialogType = dialogType;
  }

  @Override
  public AuthInfo authenticate() throws AuthException {
    final CountDownLatch sync = new CountDownLatch(1);
    final AtomicReference<String> username = new AtomicReference<>();
    final AtomicReference<String> password = new AtomicReference<>();

    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        try {

          final T authUi = dialogType.newInstance();
          new UsernameAndPasswordDialog();
          authUi.setCallbackAuthenticate(new ActionPerformedCallback() {
            @Override
            public void actionPerformed() {
              final char[][] authValues = authUi.getAuthValue();
              username.set(new String(authValues[0]));
              password.set(new String(authValues[1]));
              authUi.dismiss();
              sync.countDown();
            }
          });
          authUi.present();

        } catch (final InstantiationException e) {
          sync.countDown();
          e.printStackTrace();
        } catch (final IllegalAccessException e) {
          sync.countDown();
          e.printStackTrace();
        }
      }
    });

    try {
      sync.await();
    } catch (final InterruptedException e) {
      throw new AuthException("Error waiting for username password dialog", e);
    }

    final UserPasswordAuthInfo authInfo = new UserPasswordAuthInfo();
    authInfo.setUserName(username.get());
    authInfo.setPassWord(password.get());
    return authInfo;
  }

  @Override
  public String getFriendlyName() {
    return "Username and password";
  }

  @Override
  public boolean authenticatesAuthomatically() {
    return false;
  }
}
