package kr.co.model

data class FileInfo(
    val name: String,
    val path: String,
    val type: Type,
    val isDirectory: Boolean,
    val isHidden: Boolean,
    val size: Long,
) {
    enum class Type {
        PDF,
        IMAGE,
        FOLDER
        ;

        companion object {
            fun from(extension: String): Type =
                when(extension) {
                    "pdf" -> PDF
                    "jpg", "jpeg", "png", "gif" -> IMAGE
                    else -> IMAGE
                }
        }
    }
}
