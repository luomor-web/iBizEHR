import { Http,Util } from '@/utils';
import PIMPAPERServiceBase from './pimpaper-service-base';


/**
 * 论文信息服务对象
 *
 * @export
 * @class PIMPAPERService
 * @extends {PIMPAPERServiceBase}
 */
export default class PIMPAPERService extends PIMPAPERServiceBase {

    /**
     * Creates an instance of  PIMPAPERService.
     * 
     * @param {*} [opts={}]
     * @memberof  PIMPAPERService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}