package com.example.demo.prove

import android.Manifest
import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.security.keystore.KeyProperties
import android.support.annotation.RequiresApi
import android.support.v4.app.ActivityCompat
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat
import com.rebecca.lib.tools.Loger
import javax.crypto.Cipher

class ProveFinger(val context: Context) {

  //========================= =====================
  val fm by lazy {
    FingerprintManagerCompat.from(context).also {
      Loger.show("""_
        |硬件支持= ${it.isHardwareDetected}
        |录入= ${it.hasEnrolledFingerprints()}
    """)
    }
  }

  //========================= =====================
  fun build() {
  }

  @TargetApi(Build.VERSION_CODES.M)
  fun start() {
    fm.authenticate(null, 0, null, cb, null)
    val cipher = Cipher.getInstance(KeyProperties.KEY_ALGORITHM_AES + "/"
                                    + KeyProperties.BLOCK_MODE_CBC + "/"
                                    + KeyProperties.ENCRYPTION_PADDING_PKCS7)
    val cry = FingerprintManagerCompat.CryptoObject(cipher)
    Loger.show("start")
  }
  //========================= =====================

  fun isOpen(): Boolean {
    return isSupport() && fm.hasEnrolledFingerprints()
  }

  fun isSupport(): Boolean {
    return fm.isHardwareDetected
  }

  @RequiresApi(Build.VERSION_CODES.M)
  private fun k() {
    ActivityCompat.checkSelfPermission(context, Manifest.permission.USE_FINGERPRINT)

  }

  //========================= =====================
  private val cb = object : FingerprintManagerCompat.AuthenticationCallback() {
    override fun onAuthenticationError(errMsgId: Int, errString: CharSequence?) {
      super.onAuthenticationError(errMsgId, errString)
      Loger.show("error= $errMsgId : $errString")
    }

    override fun onAuthenticationFailed() {
      super.onAuthenticationFailed()
      Loger.show("Failed")
    }

    override fun onAuthenticationHelp(helpMsgId: Int, helpString: CharSequence?) {
      super.onAuthenticationHelp(helpMsgId, helpString)
      Loger.show("Help= $helpMsgId : $helpString")
    }

    override fun onAuthenticationSucceeded(result: FingerprintManagerCompat.AuthenticationResult?) {
      super.onAuthenticationSucceeded(result)
      Loger.show("Succeeded= $result")
    }
  }
}