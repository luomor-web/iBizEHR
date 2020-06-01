/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof MainGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof MainGridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'pcmxkmlid',
          prop: 'pcmxkmlid',
          dataType: 'PICKUP',
        },
        {
          name: 'nd2',
          prop: 'nd2',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'nd',
          prop: 'nd',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'pcmgxmlid',
          prop: 'pcmgxmlid',
          dataType: 'PICKUP',
        },
        {
          name: 'pcmxkmlname',
          prop: 'pcmxkmlname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'pcmgxmlname',
          prop: 'pcmgxmlname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'pcmgxxktempname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pcmgxxktempid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'pcmgxxktempid',
          dataType: 'GUID',
        },
        {
          name: 'pcmgxxktemp',
          prop: 'pcmgxxktempid',
        },
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
        },
        {
          name:'srfparentdata',
          prop:'srfparentdata'
        },
        // 前端新增修改标识，新增为"0",修改为"1"或未设值
        {
          name: 'srffrontuf',
          prop: 'srffrontuf',
          dataType: 'TEXT',
        },
      ]
    }
  }

}