package org.opendatakit.suitcase.utils;

import org.opendatakit.suitcase.model.CloudEndpointInfo;
import org.opendatakit.suitcase.net.UploadTask;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.opendatakit.suitcase.ui.MessageString.*;

public class FieldsValidatorUtils {
  /**
   * Checks fields used for login
   *
   * @param cloudEndpointUrl
   * @param appId
   * @param username
   * @param password
   * @param isAnonymous
   * @return error message or null if no error found
   */
  public static String checkLoginFields(String cloudEndpointUrl, String appId, String username,
      String password, boolean isAnonymous) {
    StringBuilder errorMsgBuilder = new StringBuilder();

    if (cloudEndpointUrl.isEmpty()) {
      errorMsgBuilder.append(CLOUD_ENDPOINT_EMPTY).append(NEW_LINE);
    }

    if (appId.isEmpty()) {
      errorMsgBuilder.append(APP_ID_EMPTY).append(NEW_LINE);
    }

    // these are not required for anonymous authentication
    if (!isAnonymous) {
      if (username.isEmpty()) {
        errorMsgBuilder.append(USERNAME_EMPTY).append(NEW_LINE);
      }

      if (password.isEmpty()) {
        errorMsgBuilder.append(PASSWORD_EMPTY).append(NEW_LINE);
      }
    }

    return errorMsgBuilder.length() > 0 ? errorMsgBuilder.toString().trim() : null;
  }

  public static String checkDownloadFields(String tableId, String savePath,
      CloudEndpointInfo cloudEndpointInfo) {
    StringBuilder errorMsgBuilder = new StringBuilder();

    if (tableId.isEmpty()) {
      errorMsgBuilder.append(TABLE_ID_EMPTY).append(NEW_LINE);
    }

    if (!tableId.isEmpty() && !cloudEndpointInfo.tableIdExists(tableId)) {
      errorMsgBuilder.append(BAD_TABLE_ID).append(NEW_LINE);
    }

    if (savePath.isEmpty()) {
      errorMsgBuilder.append(SAVE_PATH_EMPTY).append(NEW_LINE);
    }

    return errorMsgBuilder.length() > 0 ? errorMsgBuilder.toString().trim() : null;
  }

  public static String checkUploadFields(String version, String dataPath, String uploadOp) {
    StringBuilder errorMsgBuilder = new StringBuilder();

    if (version.isEmpty()) {
      errorMsgBuilder.append(VERSION_EMPTY).append(NEW_LINE);
    }

    if (dataPath.isEmpty()) {
      errorMsgBuilder.append(DATA_PATH_EMPTY).append(NEW_LINE);
    } else {
      if (Files.notExists(Paths.get(dataPath))) {
        errorMsgBuilder.append(DATA_DIR_NOT_EXIST).append(NEW_LINE);
      } else {
        if (uploadOp != null) {
          String upperUploadOp = uploadOp.toUpperCase();
          if (upperUploadOp.equals(UploadTask.RESET_APP_OP)) {
            // check directory validity by checking if necessary sub-directories are present
            if (!FileUtils.checkUploadDir(dataPath)) {
              errorMsgBuilder.append(DATA_DIR_INVALID).append(NEW_LINE);
            }
          }
        }
      }
    }
    return errorMsgBuilder.length() > 0 ? errorMsgBuilder.toString().trim() : null;
  }


  public static String checkResetFields(String version) {
    StringBuilder errorMsgBuilder = new StringBuilder();

    if (version.isEmpty()) {
      errorMsgBuilder.append(VERSION_EMPTY).append(NEW_LINE);
    }

    return errorMsgBuilder.length() > 0 ? errorMsgBuilder.toString().trim() : null;
  }

  public static String checkUpdateFields(String tableId, String version, String dataPath) {
    StringBuilder errorMsgBuilder = new StringBuilder();

    if (tableId.isEmpty()) {
      errorMsgBuilder.append(TABLE_ID_EMPTY).append(NEW_LINE);
    }

    if (version.isEmpty()) {
      errorMsgBuilder.append(VERSION_EMPTY).append(NEW_LINE);
    }

    if (dataPath.isEmpty()) {
      errorMsgBuilder.append(DATA_PATH_EMPTY).append(NEW_LINE);
    }

    return errorMsgBuilder.length() > 0 ? errorMsgBuilder.toString().trim() : null;
  }

  public static String checkTableOpFields(String tableId, String version, String dataPath,
      String tableOp) {
    StringBuilder errorMsgBuilder = new StringBuilder();

    if (tableId.isEmpty()) {
      errorMsgBuilder.append(TABLE_ID_EMPTY).append(NEW_LINE);
    }

    if (version.isEmpty()) {
      errorMsgBuilder.append(VERSION_EMPTY).append(NEW_LINE);
    }

    return errorMsgBuilder.length() > 0 ? errorMsgBuilder.toString().trim() : null;
  }

  public static String checkPermissionFields(String version, String dataPath) {
    StringBuilder errorMsgBuilder = new StringBuilder();

    if (dataPath.isEmpty()) {
      errorMsgBuilder.append(DATA_PATH_EMPTY).append(NEW_LINE);
    }

    if (version.isEmpty()) {
      errorMsgBuilder.append(VERSION_EMPTY).append(NEW_LINE);
    }

    return errorMsgBuilder.length() > 0 ? errorMsgBuilder.toString().trim() : null;
  }
}
