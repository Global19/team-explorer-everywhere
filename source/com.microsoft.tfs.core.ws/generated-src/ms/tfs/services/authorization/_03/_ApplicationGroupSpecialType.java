// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT license. See License.txt in the repository root.

 /*
 * This file was automatically generated by com.microsoft.tfs.core.ws.generator.Generator
 * from the /enumeration.vm template.
 */
package ms.tfs.services.authorization._03;

import com.microsoft.tfs.core.ws.runtime.exceptions.*;
import com.microsoft.tfs.core.ws.runtime.serialization.*;
import com.microsoft.tfs.core.ws.runtime.types.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Automatically generated enumeration class.
 */
public final class _ApplicationGroupSpecialType
    extends Enumeration
{
    /**
     * This map lets static methods in this class map strings to
     * the correct instance type at deserialization time.
     */
    private final static Map VALUES_TO_INSTANCES = new HashMap();
    public static final _ApplicationGroupSpecialType Generic = new _ApplicationGroupSpecialType("Generic");
    public static final _ApplicationGroupSpecialType AdministrativeApplicationGroup = new _ApplicationGroupSpecialType(
                "AdministrativeApplicationGroup");
    public static final _ApplicationGroupSpecialType ServiceApplicationGroup = new _ApplicationGroupSpecialType(
                "ServiceApplicationGroup");
    public static final _ApplicationGroupSpecialType EveryoneApplicationGroup = new _ApplicationGroupSpecialType(
                "EveryoneApplicationGroup");
    public static final _ApplicationGroupSpecialType LicenseesApplicationGroup = new _ApplicationGroupSpecialType(
                "LicenseesApplicationGroup");

    private _ApplicationGroupSpecialType(final String name)
    {
        super(name, _ApplicationGroupSpecialType.VALUES_TO_INSTANCES);
    }

    /**
     * Gets the specific enumeration value in this class appropriate for the given
     * XML attribute value.  If no value is known, null is returned (_DEFAULT is not used; that
     * value is for when the attribute is not present).
     *
     * @param value
     *        the XML attribute value (not null)
     * @return the appropriate enumeration instance.
     */
    public static _ApplicationGroupSpecialType fromString(final String value)
        throws SOAPSerializationException
    {
        return (_ApplicationGroupSpecialType) Enumeration.fromString(
            value,
            _ApplicationGroupSpecialType.VALUES_TO_INSTANCES);
    }
}
