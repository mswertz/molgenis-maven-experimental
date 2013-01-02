package org.molgenis.db;

public interface TupleIterable extends Iterable<Tuple>
{
	Tuple next();
}
