/**
 * xml工具类
 * 
 * @export
 * @class XMLWriter
 */
export class XMLWriter {
    public XML: any[] = [];
    public nodes: any[] = [];
    public State = '';

    /**
     * 
     * 
     * @param {any} Str 
     * @returns 
     * @memberof XMLWriter
     */
    public formatXML(Str: any) {
        if (Str) {
            return Str.replace(/&/g, '&amp;').replace(/\"/g, '&quot;').replace(/</g, '&lt;').replace(/>/g, '&gt;').replace(/\n/g, '&#xA;').replace(/\r/g, '&#xD;');
        }
        return '';
    }

    /**
     * 
     * 
     * @param {any} Name 
     * @returns 
     * @memberof XMLWriter
     */
    public beginNode(Name: any) {
        if (!Name) {
            return;
        }
        if (this.State === 'beg') {
            this.XML.push('>');
        }
        this.State = 'beg';
        this.nodes.push(Name);
        this.XML.push('<' + Name);
    }

    /**
     * 
     * 
     * @memberof XMLWriter
     */
    public endNode() {
        if (this.State === 'beg') {
            this.XML.push('/>');
            this.nodes.pop();
        } else if (this.nodes.length > 0) {
            this.XML.push('</' + this.nodes.pop() + '>');
        }
        this.State = '';
    }

    /**
     * 
     * 
     * @param {any} Name 
     * @param {any} Value 
     * @returns 
     * @memberof XMLWriter
     */
    public attrib(Name: any, Value: any) {
        if (this.State !== 'beg' || !Name) {
            return;
        }
        this.XML.push(' ' + Name + '="' + this.formatXML(Value) + '"');
    }

    /**
     * 
     * 
     * @param {any} Value 
     * @memberof XMLWriter
     */
    public writeString(Value: any) {
        if (this.State === 'beg') {
            this.XML.push('>');
        }
        this.XML.push(this.formatXML(Value));
        this.State = '';
    }

    /**
     * 
     * 
     * @param {any} Name 
     * @param {any} Value 
     * @returns 
     * @memberof XMLWriter
     */
    public node(Name: any, Value: any) {
        if (!Name) {
            return;
        }
        if (this.State === 'beg') {
            this.XML.push('>');
        }
        this.XML.push((Value === '' || !Value) ? '<' + Name + '/>' : '<' + Name + '>' + this.formatXML(Value) + '</' + Name + '>');
        this.State = '';
    }

    /**
     * 
     * 
     * @memberof XMLWriter
     */
    public close() {
        while (this.nodes.length > 0) {
            this.endNode();
        }
        this.State = 'closed';
    }

    /**
     * 
     * 
     * @returns 
     * @memberof XMLWriter
     */
    public toString() { return this.XML.join(''); }
}