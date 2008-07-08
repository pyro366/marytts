/**
 * Copyright 2000-2006 DFKI GmbH.
 * All Rights Reserved.  Use is subject to license terms.
 * 
 * Permission is hereby granted, free of charge, to use and distribute
 * this software and its documentation without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of this work, and to
 * permit persons to whom this work is furnished to do so, subject to
 * the following conditions:
 * 
 * 1. The code must retain the above copyright notice, this list of
 *    conditions and the following disclaimer.
 * 2. Any modifications must be clearly marked as such.
 * 3. Original authors' names are not deleted.
 * 4. The authors' names are not used to endorse or promote products
 *    derived from this software without specific prior written
 *    permission.
 *
 * DFKI GMBH AND THE CONTRIBUTORS TO THIS WORK DISCLAIM ALL WARRANTIES WITH
 * REGARD TO THIS SOFTWARE, INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS, IN NO EVENT SHALL DFKI GMBH NOR THE
 * CONTRIBUTORS BE LIABLE FOR ANY SPECIAL, INDIRECT OR CONSEQUENTIAL
 * DAMAGES OR ANY DAMAGES WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR
 * PROFITS, WHETHER IN AN ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS
 * ACTION, ARISING OUT OF OR IN CONNECTION WITH THE USE OR PERFORMANCE OF
 * THIS SOFTWARE.
 */package marytts;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import marytts.util.FileUtils;
import marytts.util.MaryUtils;


/**
 * Provide Version information for the Mary server and client.
 * @author Marc Schr&ouml;der
 *
 */
public class Version {
    private static String specificationVersion;
    private static String implementationVersion;

    static {
        InputStream specVersionStream = Version.class.
            getResourceAsStream("specification-version.txt");
        if (specVersionStream != null) {
            try {
                specificationVersion = FileUtils.getStreamAsString(specVersionStream, "UTF-8").trim();
            } catch (IOException e) {
                specificationVersion = "undeterminable";
            }
        } else {
            specificationVersion = "unknown";
        }
        
        InputStream implVersionStream = Version.class.
            getResourceAsStream("implementation-version.txt");
        if (implVersionStream != null) {
            try {
                implementationVersion = FileUtils.getStreamAsString(implVersionStream, "UTF-8").trim();
            } catch (IOException e) {
                implementationVersion = "undeterminable";
            }
        } else {
            implementationVersion = "unknown";
        }
    }

    /** Specification version */
    public static String specificationVersion() {
        return specificationVersion;
    }
    /** Implementation version */
    public static String implementationVersion() {
        return implementationVersion;
    }

}