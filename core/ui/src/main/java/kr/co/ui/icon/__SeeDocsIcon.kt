package kr.co.ui.icon

import androidx.compose.ui.graphics.vector.ImageVector
import kr.co.ui.icon.seedocsicon.ArrowForward
import kr.co.ui.icon.seedocsicon.Close
import kr.co.ui.icon.seedocsicon.Explore
import kr.co.ui.icon.seedocsicon.Folder
import kr.co.ui.icon.seedocsicon.RecentFill
import kr.co.ui.icon.seedocsicon.Search
import kr.co.ui.icon.seedocsicon.Settings
import kr.co.ui.icon.seedocsicon.StarFill
import kr.co.ui.icon.seedocsicon.PDF
import kotlin.collections.List as ____KtList

public object SeeDocsIcon

private var __AllIcons: ____KtList<ImageVector>? = null

public val SeeDocsIcon.AllIcons: ____KtList<ImageVector>
  get() {
    if (__AllIcons != null) {
      return __AllIcons!!
    }
    __AllIcons = listOf(ArrowForward, Close, Explore, Folder, PDF, RecentFill, Search,
        Settings, StarFill)
    return __AllIcons!!
  }
