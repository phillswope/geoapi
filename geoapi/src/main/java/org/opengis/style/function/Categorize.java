/*$************************************************************************************************
 **
 ** $Id$
 **
 ** $URL$
 **
 ** Copyright (C) 2008 Open GIS Consortium, Inc.
 ** All Rights Reserved. http://www.opengis.org/legal/
 **
 *************************************************************************************************/
package org.opengis.style.function;

import java.util.SortedMap;
import org.opengis.annotation.XmlElement;
import org.opengis.filter.expression.Expression;
import org.opengis.filter.expression.Function;
import org.opengis.filter.expression.Literal;

/**
 * Categorization: The transformation of continuous values to distinct values. This is
 * for example needed to generate choropleth maps from continuous attributes.
 * Another example would be the stepwise selection of different text heights or line
 * widths in dependence from such an attribute.
 *
 * In case the Categorize (or Interpolate) function is used inside a RasterSymbolizer as a
 * ColorMap, the LookupValue is set to the fixed value “Rasterdata”.
 *
 * @version <A HREF="http://www.opengeospatial.org/standards/symbol">Symbology Encoding Implementation Specification 1.1.0</A>
 * @author Open Geospatial Consortium
 * @author Johann Sorel (Geomatys)
 * @since GeoAPI 2.2
 */
@XmlElement("Categorize")
public interface Categorize extends Function{

    /**
     * Get lookup value.
     *
     * @return Expression
     */
    @XmlElement("LookupValue")
    Expression getLookupValue();

    /**
     * The Thresholds have to be specified in ascending order and (like the LookupValue)
     * have to be of a uniform and orderable type. The value of the function is determined by
     * looking up into which interval between two thresholds the LookupValue falls. The first
     * interval ranges from -Infinity to the first given threshold and the last one accordingly
     * from the last threshold to +Infinity.
     *
     */
    SortedMap<Literal,Literal> getThresholds();

    /**
     * Get the function direction.
     * Default is SUCCEEDING.
     *
     * @return SUCCEEDING or PRECEDING
     */
    @XmlElement("ThreshholdsBelongTo")
    ThreshholdsBelongTo getBelongTo();

}