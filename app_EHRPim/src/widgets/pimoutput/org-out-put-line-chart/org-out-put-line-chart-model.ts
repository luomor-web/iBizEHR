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
        name:'query',
        prop:'query'
      },
		]
	}

}