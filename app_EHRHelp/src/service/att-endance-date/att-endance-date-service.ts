import { Http,Util } from '@/utils';
import AttEndanceDateServiceBase from './att-endance-date-service-base';


/**
 * 考勤日期服务对象
 *
 * @export
 * @class AttEndanceDateService
 * @extends {AttEndanceDateServiceBase}
 */
export default class AttEndanceDateService extends AttEndanceDateServiceBase {

    /**
     * Creates an instance of  AttEndanceDateService.
     * 
     * @param {*} [opts={}]
     * @memberof  AttEndanceDateService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}