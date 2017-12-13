package obj;

public class CK_FLAGS {

	public static final Long CKF_TOKEN_PRESENT     =0x00000001L;
	public static final Long CKF_REMOVABLE_DEVICE  =0x00000002L;
	public static final Long CKF_HW_SLOT           =0x00000004L;
	public static final Long CKF_RNG                     =0x00000001L;
	public static final Long CKF_WRITE_PROTECTED         =0x00000002L;
	public static final Long CKF_LOGIN_REQUIRED          =0x00000004L;
	public static final Long CKF_USER_PIN_INITIALIZED    =0x00000008L;
	public static final Long CKF_RESTORE_KEY_NOT_NEEDED  =0x00000020L;
	public static final Long CKF_CLOCK_ON_TOKEN          =0x00000040L;
	public static final Long CKF_PROTECTED_AUTHENTICATION_PATH =0x00000100L;
	public static final Long CKF_DUAL_CRYPTO_OPERATIONS  =0x00000200L;
	public static final Long CKF_TOKEN_INITIALIZED       =0x00000400L;
	public static final Long CKF_SECONDARY_AUTHENTICATION  =0x00000800L;
	public static final Long CKF_USER_PIN_COUNT_LOW       =0x00010000L;
	public static final Long CKF_USER_PIN_FINAL_TRY       =0x00020000L;
	public static final Long CKF_USER_PIN_LOCKED          =0x00040000L;
	public static final Long CKF_USER_PIN_TO_BE_CHANGED   =0x00080000L;
	public static final Long CKF_SO_PIN_COUNT_LOW         =0x00100000L;
	public static final Long CKF_SO_PIN_FINAL_TRY         =0x00200000L;
	public static final Long CKF_SO_PIN_LOCKED            =0x00400000L;
	public static final Long CKF_SO_PIN_TO_BE_CHANGED     =0x00800000L;
	public static final Long CKF_RW_SESSION          =0x00000002L;
	public static final Long CKF_SERIAL_SESSION      =0x00000004L;
	public static final Long CKF_ARRAY_ATTRIBUTE    =0x40000000L;
	public static final Long CKA_WRAP_TEMPLATE        =(CKF_ARRAY_ATTRIBUTE|0x00000211);
	public static final Long CKA_UNWRAP_TEMPLATE      =(CKF_ARRAY_ATTRIBUTE|0x00000212);
	public static final Long CKA_ALLOWED_MECHANISMS   =(CKF_ARRAY_ATTRIBUTE|0x00000600);
	public static final Long CKF_HW                 =0x00000001L;
	public static final Long CKF_ENCRYPT            =0x00000100L;
	public static final Long CKF_DECRYPT            =0x00000200L;
	public static final Long CKF_DIGEST             =0x00000400L;
	public static final Long CKF_SIGN               =0x00000800L;
	public static final Long CKF_SIGN_RECOVER       =0x00001000L;
	public static final Long CKF_VERIFY             =0x00002000L;
	public static final Long CKF_VERIFY_RECOVER     =0x00004000L;
	public static final Long CKF_GENERATE           =0x00008000L;
	public static final Long CKF_GENERATE_KEY_PAIR  =0x00010000L;
	public static final Long CKF_WRAP               =0x00020000L;
	public static final Long CKF_UNWRAP             =0x00040000L;
	public static final Long CKF_DERIVE             =0x00080000L;
	public static final Long CKF_EC_F_P             =0x00100000L;
	public static final Long CKF_EC_F_2M            =0x00200000L;
	public static final Long CKF_EC_ECPARAMETERS    =0x00400000L;
	public static final Long CKF_EC_NAMEDCURVE      =0x00800000L;
	public static final Long CKF_EC_UNCOMPRESS      =0x01000000L;
	public static final Long CKF_EC_COMPRESS        =0x02000000L;
	public static final Long CKF_EXTENSION          =0x80000000L;
	public static final Long CKF_LIBRARY_CANT_CREATE_OS_THREADS =0x00000001L;
	public static final Long CKF_OS_LOCKING_OK                  =0x00000002L;
	public static final Long CKF_DONT_BLOCK        =0x00000001L;
	public static final Long CKF_NEXT_OTP          =0x00000001L;
	public static final Long CKF_EXCLUDE_TIME      =0x00000002L;
	public static final Long CKF_EXCLUDE_COUNTER   =0x00000004L;
	public static final Long CKF_EXCLUDE_CHALLENGE =0x00000008L;
	public static final Long CKF_EXCLUDE_PIN       =0x00000010L;
	public static final Long CKF_USER_FRIENDLY_OTP =0x00000020L;
}