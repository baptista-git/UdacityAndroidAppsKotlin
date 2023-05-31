package com.tech.baptista.devbyteviewer.screens.devbyte

import com.tech.baptista.devbyteviewer.domain.Video


/**
 * Click listener for Videos. By giving the block a name it helps a reader understand what it does.
 *
 */
class VideoClick(val block: (Video) -> Unit) {
    /**
     * Called when a video is clicked
     *
     * @param video the video that was clicked
     */
    fun onClick(video: Video) = block(video)
}