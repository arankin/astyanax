package com.netflix.astyanax.query;

import java.nio.ByteBuffer;

import com.netflix.astyanax.Execution;
import com.netflix.astyanax.model.ByteBufferRange;
import com.netflix.astyanax.model.ColumnSlice;
import com.netflix.astyanax.model.Rows;

/**
 * Interface to narrow down the path and column slices within a query after the
 * keys were seleted using the ColumnFamilyQuery.
 */
public interface RowSliceQuery<K, C> extends Execution<Rows<K,C>> {
	/**
	 * Specify a non-contiguous set of columns to retrieve.
	 * @param columns
	 * @return
	 */
	RowSliceQuery<K, C> withColumnSlice(C... columns);

	/**
	 * Use this when your application caches the column slice.
	 * @param slice
	 * @return
	 */
	RowSliceQuery<K, C> withColumnSlice(ColumnSlice<C> columns);
	
	/**
	 * Specify a range of columns to return.  
	 * @param startColumn	First column in the range
	 * @param endColumn		Last column in the range
	 * @param reversed		True if the order should be reversed.  Note that for
	 * 						reversed, startColumn should be greater than endColumn.
	 * @param count			Maximum number of columns to return (similar to SQL LIMIT)
	 * @return
	 */
	RowSliceQuery<K, C> withColumnRange(C startColumn, C endColumn, boolean reversed, int count);
	
	/**
	 * Specify a range and provide pre-constructed start and end columns.
	 * Use this with Composite columns
	 * 
	 * @param startColumn
	 * @param endColumn
	 * @param reversed
	 * @param count
	 * @return
	 */
	RowSliceQuery<K, C> withColumnRange(ByteBuffer startColumn, ByteBuffer endColumn, boolean reversed, int count);
	
	/**
	 * Specify a range of composite columns.  Use this in conjunction with the
	 * AnnotatedCompositeSerializer.buildRange().
	 * 
	 * @param range
	 * @return
	 */
	RowSliceQuery<K, C> withColumnRange(ByteBufferRange range);
}