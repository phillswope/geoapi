/**************************************************************************************************
 **
 ** $Id$
 **
 ** $Source$
 **
 ** Copyright (C) 2003 Open GIS Consortium, Inc. All Rights Reserved. http://www.opengis.org/Legal/
 **
 *************************************************************************************************/
package org.opengis.spatialschema;

import org.opengis.crs.crs.CoordinateReferenceSystem;
import org.opengis.crs.crs.UnsupportedCRSException;

/**
 * <code>SpatialschemaFactory</code> defines a common abstraction for classes that
 * create <code>DirectPosition</code>s.  New coordinates are created by calling
 * <code>createDirectPosition</code>.
 *
 * @author Open GIS Consortium, Inc.
 * @version $Revision$, $Date$
 *
 * @revisit This interfaces seems to duplicate factories found in other packages.
 *          Furthermore, reflections are more expensive than ordinary methods and
 *          are not type-safe.
 */
public interface SpatialschemaFactory {

    /**
     * Creates a spatialschema object instance of the type 
     * corresponding to the Class and CoordinateReferenceSystem. 
     * An appropriate combination of Class and CoordinateReferenceSystem can be verified with
     *  <code>CommonFactory.getCommonCapabilities().getSupportedSpatialschemaObjects(CoordinateReferenceSystem)</code>.
     * @param coordInterface The <code>Class</code> of a spatialschema object
     *   interface.
     * @param crs the Coordinate Reference System to be used.
     * @return Returns a newly created <code>Object</code> which should be cast to the <code>Class</code>.
     */
    public Object createObjectWithCRS(Class coordInterface, CoordinateReferenceSystem crs)
        throws UnsupportedCRSException;

    /**
     * Creates a spatialschema object instance of the type 
     * corresponding to the Class and CoordinateReferenceSystem. 
     * An appropriate combination of Class and CoordinateReferenceSystem can be verified with
     *  <code>CommonFactory.getCommonCapabilities().getSupportedSpatialschemaObjects(CoordinateReferenceSystem)</code>.
     * @param coordInterface The <code>Class</code> of a spatialschema object
     *   interface.
     * @return Returns a newly created <code>PointArray</code>.
     */
    public Object createObject(Class coordInterface);

}
