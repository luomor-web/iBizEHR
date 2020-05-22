import { Http,Util } from '@/utils';
import CodeItemServiceBase from './code-item-service-base';


/**
 * 代码项服务对象
 *
 * @export
 * @class CodeItemService
 * @extends {CodeItemServiceBase}
 */
export default class CodeItemService extends CodeItemServiceBase {

    /**
     * Creates an instance of  CodeItemService.
     * 
     * @param {*} [opts={}]
     * @memberof  CodeItemService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}