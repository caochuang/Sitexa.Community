/*
 *   Copyright (C) 2015 Sitexa Open Source Project
 *   <p>
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *   <p>
 *   http://www.apache.org/licenses/LICENSE-2.0
 *   <p>
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.sitexa.android.data.cache;

import java.io.File;

/**
 * Created by xnpeng on 15-10-9.
 */
public class CacheWriter implements Runnable {

    private final FileManager fileManager;
    private final File fileToWrite;
    private final String fileContent;

    public CacheWriter(FileManager fileManager, File fileToWrite, String fileContent) {
        this.fileManager = fileManager;
        this.fileToWrite = fileToWrite;
        this.fileContent = fileContent;
    }

    @Override
    public void run() {
        this.fileManager.writeToFile(fileToWrite, fileContent);
    }
}
