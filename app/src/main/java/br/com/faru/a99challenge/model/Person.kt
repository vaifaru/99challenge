package br.com.faru.a99challenge.model

import android.os.Parcel
import android.os.Parcelable

import java.util.Date

data class Person(var id: String? = null,
                  var name: String? = null,
                  var image: String? = null,
                  var birthday: Date? = null,
                  var bio: String? = null) : Parcelable, Comparable<Person> {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readSerializable() as Date?,
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(image)
        parcel.writeSerializable(birthday)
        parcel.writeString(bio)
    }

    override fun describeContents() = 0

    override fun compareTo(other: Person) = other.name?.let { this.name?.compareTo(it) } ?: 0

    companion object CREATOR : Parcelable.Creator<Person> {
        override fun createFromParcel(parcel: Parcel): Person = Person(parcel)
        override fun newArray(size: Int): Array<Person?> = arrayOfNulls(size)
    }
}
