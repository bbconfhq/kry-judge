package org.oooc.kry.global.json

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

class OffsetDateTimeCustomSerializer(
    val formatter: DateTimeFormatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME
) : JsonSerializer<OffsetDateTime>() {
    override fun serialize(value: OffsetDateTime?, gen: JsonGenerator?, serializers: SerializerProvider?) {
        gen!!.writeString(value!!.format(this.formatter))
    }
}