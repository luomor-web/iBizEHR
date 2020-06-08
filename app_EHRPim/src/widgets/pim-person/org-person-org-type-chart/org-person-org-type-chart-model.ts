/**
 * OrgPersonOrgType 部件模型
 *
 * @export
 * @class OrgPersonOrgTypeModel
 */
export default class OrgPersonOrgTypeModel {

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof OrgPersonOrgTypePortlet_OrgPersonOrgTypePie_chartMode
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