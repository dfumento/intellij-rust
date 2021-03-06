package org.rust.lang.core.types

import org.rust.lang.core.psi.RustEnumItemElement
import org.rust.lang.core.types.visitors.RustTypeVisitor

class RustEnumType(val enum: RustEnumItemElement) : RustStructOrEnumTypeBase(enum) {

    override fun <T> accept(visitor: RustTypeVisitor<T>): T = visitor.visitEnum(this)

    override fun equals(other: Any?): Boolean = other is RustEnumType && other.enum === enum

    override fun hashCode(): Int = enum.hashCode() * 12289 + 9293

    override fun toString(): String = enum.name ?: "<anonymous>"
}
