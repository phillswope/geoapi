/*$************************************************************************************************
 **
 ** $Id$
 **
 ** $Source$
 **
 ** Copyright (C) 2003 Open GIS Consortium, Inc. All Rights Reserved. http://www.opengis.org/Legal/
 **
 *************************************************************************************************/
package org.opengis.metadata.distribution;

// J2SE direct dependencies
import java.util.Locale;


/**
 * Description of the computer language construct that specifies the representation
 * of data objects in a record, file, message, storage device or transmission channel.
 *
 * @UML datatype MD_Format
 * @author ISO 19115
 * @author <A HREF="http://www.opengis.org">OpenGIS&reg; consortium</A>
 * @version <A HREF="http://www.opengis.org/docs/01-111.pdf">Abstract specification 5.0</A>
 */
public interface Format {
    /**
     * Name of the data transfer format(s).
     *
     * @UML mandatory name
     */
    String getName(Locale locale);

    /**
     * Version of the format (date, number, etc.).
     *
     * @UML mandatory version
     */
    String getVersion(Locale locale);

    /**
     * Amendment number of the format version.
     *
     * @UML optional amendmentNumber
     */
    String getAmendmentNumber(Locale locale);

    /**
     * Name of a subset, profile, or product specification of the format.
     *
     * @UML optional specification
     */
    String getSpecification(Locale locale);

    /**
     * Recommendations of algorithms or processes that can be applied to read or
     * expand resources to which compression techniques have been applied.
     *
     * @UML optional fileDecompressionTechnique
     */
    String getFileDecompressionTechnique(Locale locale);

    /**
     * Provides information about the distributorís format.
     *
     * @UML optional formatDistributor
     */
    Distributor[] getFormatDistributors();
}
