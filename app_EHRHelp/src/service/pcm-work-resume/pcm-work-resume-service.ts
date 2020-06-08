import { Http,Util } from '@/utils';
import PcmWorkResumeServiceBase from './pcm-work-resume-service-base';


/**
 * 工作履历服务对象
 *
 * @export
 * @class PcmWorkResumeService
 * @extends {PcmWorkResumeServiceBase}
 */
export default class PcmWorkResumeService extends PcmWorkResumeServiceBase {

    /**
     * Creates an instance of  PcmWorkResumeService.
     * 
     * @param {*} [opts={}]
     * @memberof  PcmWorkResumeService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}