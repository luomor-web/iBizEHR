import { Http,Util } from '@/utils';
import PcmRecruitmentServiceBase from './pcm-recruitment-service-base';


/**
 * 内部招聘信息服务对象
 *
 * @export
 * @class PcmRecruitmentService
 * @extends {PcmRecruitmentServiceBase}
 */
export default class PcmRecruitmentService extends PcmRecruitmentServiceBase {

    /**
     * Creates an instance of  PcmRecruitmentService.
     * 
     * @param {*} [opts={}]
     * @memberof  PcmRecruitmentService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}