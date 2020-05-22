/**
 * OrgPersonAge 部件模型
 *
 * @export
 * @class OrgPersonAgeModel
 */
export default class OrgPersonAgeModel {

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof OrgPersonAgeDb_sysportlet4_chartMode
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