/**
 * OrgBar 部件模型
 *
 * @export
 * @class OrgBarModel
 */
export default class OrgBarModel {

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof OrgBarDb_sysportlet1_chartMode
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