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
			name:'size',
			prop:'size'
			},
			{
			name:'query',
			prop:'query'
			},
			{
			name:'page',
			prop:'page'
			},
			{
			name:'sort',
			prop:'sort'
			}
		]
	}

}