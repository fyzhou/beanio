/*
 * Copyright 2011-2012 Kevin Seim
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.beanio.internal.parser.format.delimited;

import java.util.List;

import org.beanio.internal.parser.UnmarshallingContext;

/**
 * An {@link UnmarshallingContext} for a delimited record.
 * 
 * <p>The record value type for a delimited record is a <tt>String</tt> array.
 *  
 * @author Kevin Seim
 * @since 2.0
 */
public class DelimitedUnmarshallingContext extends UnmarshallingContext {

    private String[] fields;

    /**
     * Constructs a new <tt>DelimitedUnmarshallingContext</tt>.
     */
    public DelimitedUnmarshallingContext() { }

    @Override
    public void setRecordValue(Object value) {
        this.fields = (String[]) value;
    }

    /**
     * Returns the number of fields read from the input stream.
     * @return the number of fields
     */
    public int getFieldCount() {
        return fields.length;
    }

    /**
     * Returns the field text at the given position in the record.
     * @param position the position of the field wihin the record
     * @return the field text
     */
    public String getFieldText(String fieldName, int position) {
        position = getAdjustedFieldPosition(position);
        
        if (position < getFieldCount()) {
            String text = fields[position];
            setFieldText(fieldName, text);
            return text;
        }
        else {
            return null;
        }
    }
    
    @Override
    public Object toRecordValue(String[] array) {
        return array;
    }
    
    @Override
    public Object toRecordValue(List<String> list) {
        String[] array = new String[list.size()];
        list.toArray(array);
        return array;
    }
}
