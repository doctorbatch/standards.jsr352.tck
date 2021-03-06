/**
 * Copyright 2013 International Business Machines Corp.
 *
 * See the NOTICE file distributed with this work for additional information
 * regarding copyright ownership. Licensed under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ibm.jbatch.tck.artifacts.specialized;

import java.util.logging.Logger;

import javax.batch.api.chunk.listener.AbstractChunkListener;
import javax.batch.runtime.context.JobContext;
import javax.batch.runtime.context.StepContext;
import javax.inject.Inject;


@javax.inject.Named("chunkOnErrorCheckpointListener")
public class ChunkOnErrorCheckpointListener extends AbstractChunkListener {
    
    private final static String sourceClass = MyCustomCheckpointListener.class.getName();
    private final static Logger logger = Logger.getLogger(sourceClass);
    
    @Inject 
    JobContext jobCtx;
    
    @Inject
    StepContext stepCtx;

    @Override
    public void beforeChunk() {
        logger.fine("CUSTOMCHKPTLISTENER: beforeCheckpoint");
    }
    
    @Override
    public void afterChunk() {
        logger.fine("CUSTOMCHKPTLISTENER: afterCheckpoint");
    }
    
    @Override
    public void onError(Exception e) {
        logger.fine("CUSTOMCHKPTLISTENER: onError");
        
        jobCtx.setExitStatus("Chunk onError invoked");
    }
}
