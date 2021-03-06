// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT license. See License.txt in the repository root.

 /*
 * This file was automatically generated by com.microsoft.tfs.core.ws.generator.Generator
 * from the /complexType.vm template.
 */
package ms.tfs.build.buildinfo._03;

import com.microsoft.tfs.core.ws.runtime.*;
import com.microsoft.tfs.core.ws.runtime.serialization.*;
import com.microsoft.tfs.core.ws.runtime.types.*;
import com.microsoft.tfs.core.ws.runtime.util.*;
import com.microsoft.tfs.core.ws.runtime.xml.*;

import ms.tfs.build.buildinfo._03._ChangeSetData;

import java.lang.String;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

/**
 * Automatically generated complex type class.
 */
public class _ChangeSetData
    implements ElementSerializable, ElementDeserializable
{
    // No attributes    

    // Elements
    protected int changeSetId;
    protected String comment;
    protected String changeSetUri;
    protected String checkedInBy;

    public _ChangeSetData()
    {
        super();
    }

    public _ChangeSetData(
        final int changeSetId,
        final String comment,
        final String changeSetUri,
        final String checkedInBy)
    {
        // TODO : Call super() instead of setting all fields directly?
        setChangeSetId(changeSetId);
        setComment(comment);
        setChangeSetUri(changeSetUri);
        setCheckedInBy(checkedInBy);
    }

    public int getChangeSetId()
    {
        return this.changeSetId;
    }

    public void setChangeSetId(int value)
    {
        this.changeSetId = value;
    }

    public String getComment()
    {
        return this.comment;
    }

    public void setComment(String value)
    {
        this.comment = value;
    }

    public String getChangeSetUri()
    {
        return this.changeSetUri;
    }

    public void setChangeSetUri(String value)
    {
        this.changeSetUri = value;
    }

    public String getCheckedInBy()
    {
        return this.checkedInBy;
    }

    public void setCheckedInBy(String value)
    {
        this.checkedInBy = value;
    }

    public void writeAsElement(
        final XMLStreamWriter writer,
        final String name)
        throws XMLStreamException
    {
        writer.writeStartElement(name);

        // Elements
        XMLStreamWriterHelper.writeElement(
            writer,
            "ChangeSetId",
            this.changeSetId);
        XMLStreamWriterHelper.writeElement(
            writer,
            "Comment",
            this.comment);
        XMLStreamWriterHelper.writeElement(
            writer,
            "ChangeSetUri",
            this.changeSetUri);
        XMLStreamWriterHelper.writeElement(
            writer,
            "CheckedInBy",
            this.checkedInBy);

        writer.writeEndElement();
    }

    public void readFromElement(final XMLStreamReader reader)
        throws XMLStreamException
    {
        String localName;

        // This object uses no attributes

        // Elements
        int event;

        do
        {
            event = reader.next();

            if (event == XMLStreamConstants.START_ELEMENT)
            {
                localName = reader.getLocalName();

                if (localName.equalsIgnoreCase("ChangeSetId"))
                {
                    this.changeSetId = XMLConvert.toInt(reader.getElementText());
                }
                else if (localName.equalsIgnoreCase("Comment"))
                {
                    this.comment = reader.getElementText();
                }
                else if (localName.equalsIgnoreCase("ChangeSetUri"))
                {
                    this.changeSetUri = reader.getElementText();
                }
                else if (localName.equalsIgnoreCase("CheckedInBy"))
                {
                    this.checkedInBy = reader.getElementText();
                }
                else
                {
                    // Read the unknown child element until its end
                    XMLStreamReaderHelper.readUntilElementEnd(reader);
                }
            }
        }
        while (event != XMLStreamConstants.END_ELEMENT);
    }
}
