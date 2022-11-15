package UserRecycleView

import com.google.firebase.firestore.DocumentId


class User(
    @DocumentId var docId: String? = null,
    var name: String? = null,
    var email: String? = null,
    var phone: String = ""
)