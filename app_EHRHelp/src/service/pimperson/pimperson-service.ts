import { Http,Util } from '@/utils';
import PIMPERSONServiceBase from './pimperson-service-base';


/**
 * 人员信息服务对象
 *
 * @export
 * @class PIMPERSONService
 * @extends {PIMPERSONServiceBase}
 */
export default class PIMPERSONService extends PIMPERSONServiceBase {

    /**
     * Creates an instance of  PIMPERSONService.
     * 
     * @param {*} [opts={}]
     * @memberof  PIMPERSONService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}