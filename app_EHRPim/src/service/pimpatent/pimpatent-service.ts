import { Http,Util } from '@/utils';
import PIMPATENTServiceBase from './pimpatent-service-base';


/**
 * 专利信息服务对象
 *
 * @export
 * @class PIMPATENTService
 * @extends {PIMPATENTServiceBase}
 */
export default class PIMPATENTService extends PIMPATENTServiceBase {

    /**
     * Creates an instance of  PIMPATENTService.
     * 
     * @param {*} [opts={}]
     * @memberof  PIMPATENTService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}