/**
 * OrgEduPie 部件模型
 *
 * @export
 * @class OrgEduPieModel
 */
export default class OrgEduPieModel {

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof OrgEduPieDb_sysportlet3_chartMode
	 */
	public getDataItems(): any[] {
		return [
      {
        name:'query',
        prop:'query'
      },
		]
	}

}