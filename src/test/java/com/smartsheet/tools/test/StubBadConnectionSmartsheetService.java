/**
   Copyright 2013 Smartsheet.com

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

**/
package com.smartsheet.tools.test;

import java.io.IOException;
import java.util.Random;

import com.smartsheet.restapi.model.SmartsheetAttachment;
import com.smartsheet.restapi.model.SmartsheetHome;
import com.smartsheet.restapi.model.SmartsheetSheet;
import com.smartsheet.restapi.service.SmartsheetService;

/**
 * A stub implementation of interface {@link SmartsheetService} which simulates
 * operating on a bad connection by randomly throwing {@link IOException} from
 * user-specific methods.
 */
public class StubBadConnectionSmartsheetService extends StubSmartsheetService {

    @Override
    public SmartsheetHome getHome() throws Exception {

        if (isConnectionCurrentlyBad())
            throw fakeConnectionException();

        return super.getHome();
    }

    @Override
    public SmartsheetSheet getSheetDetails(long sheetId) throws Exception {

        if (isConnectionCurrentlyBad())
            throw fakeConnectionException();

        return super.getSheetDetails(sheetId);
    }

    @Override
    public SmartsheetAttachment getAttachmentDetails(long attachmentId) throws Exception {

        if (isConnectionCurrentlyBad())
            throw fakeConnectionException();

        return super.getAttachmentDetails(attachmentId);
    }

    private static boolean isConnectionCurrentlyBad() {
        return new Random().nextBoolean();
    }

    private static IOException fakeConnectionException() {
        return new IOException("Connection refused");
    }
}
