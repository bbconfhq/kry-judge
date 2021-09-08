package org.oooc.kry.global.json

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

class OffsetDateTimeCustomDeserializer(
    val formatter: DateTimeFormatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME
) : JsonDeserializer<OffsetDateTime>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): OffsetDateTime {
        return OffsetDateTime.parse(p!!.getText(), this.formatter)
    }
}