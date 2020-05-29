/**
 * OrgOutPutLine 部件模型
 *
 * @export
 * @class OrgOutPutLineModel
 */
export default class OrgOutPutLineModel {

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof OrgOutPutLineDb_sysportlet2_chartMode
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