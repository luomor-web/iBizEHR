import { Http,Util } from '@/utils';
import PCMRecruitmentServiceBase from './pcmrecruitment-service-base';


/**
 * 内部招聘信息服务对象
 *
 * @export
 * @class PCMRecruitmentService
 * @extends {PCMRecruitmentServiceBase}
 */
export default class PCMRecruitmentService extends PCMRecruitmentServiceBase {

    /**
     * Creates an instance of  PCMRecruitmentService.
     * 
     * @param {*} [opts={}]
     * @memberof  PCMRecruitmentService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}