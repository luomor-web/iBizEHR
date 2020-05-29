import Vue, { VNode, CreateElement } from "vue";

/**
 * 代码表
 *
 * @export
 * @interface CodeList
 */
export declare interface CodeList {
    /**
     * 常规内容绘制
     *
     * @param {CreateElement} h
     * @param {{ srfkey: string; value: string; emtpytext: string; codelistType: any; }} { srfkey, value, emtpytext, codelistType }
     * @returns
     * @memberof CodeList
     */
    render({ srfkey, value, emtpytext, codelistType }: { srfkey: string; value: string; emtpytext: string; codelistType: any; }): VNode;
    /**
     * 数字或处理
     *
     * @param {CreateElement} h
     * @param {{ srfkey: string; value: string; emtpytext: string; textSeparator: string; codelistType: any; }} { srfkey, value, emtpytext, textSeparator, codelistType }
     * @returns
     * @memberof CodeList
     */
    renderNumOr({ srfkey, value, emtpytext, textSeparator, codelistType }: { srfkey: string; value: string; emtpytext: string; textSeparator: string; codelistType: any; }): VNode;
    /**
     * 文本或处理
     *
     * @param {CreateElement} h
     * @param {{ srfkey: string; value: any; emtpytext: any; textSeparator: any; valueSeparator: any; codelistType: any; }} { srfkey, value, emtpytext, textSeparator, valueSeparator, codelistType }
     * @returns
     * @memberof CodeList
     */
    renderStrOr({ srfkey, value, emtpytext, textSeparator, valueSeparator, codelistType }: { srfkey: string; value: any; emtpytext: any; textSeparator: any; valueSeparator: any; codelistType: any; }): VNode;
}

declare module "vue/types/vue" {
    interface Vue {
        /**
         * 代码表绘制对象
         *
         * @type {CodeList}
         * @memberof Vue
         */
        $codelist: CodeList;
    }
}
