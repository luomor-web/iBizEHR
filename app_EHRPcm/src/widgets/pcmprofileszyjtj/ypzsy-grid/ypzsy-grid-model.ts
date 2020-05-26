/**
 * YPZSY 部件模型
 *
 * @export
 * @class YPZSYModel
 */
export default class YPZSYModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof YPZSYGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof YPZSYGridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'pcmprofileszyjtjname',
          prop: 'pcmprofileszyjtjname',
          dataType: 'TEXT',
        },
        {
          name: 'yglx',
          prop: 'yglx',
          dataType: 'SSCODELIST',
        },
        {
          name: 'srfmajortext',
          prop: 'pcmprofileszyjtjname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pcmprofileszyjtjid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'pcmprofileszyjtjid',
          dataType: 'GUID',
        },
        {
          name: 'pcmprofileszyjtj',
          prop: 'pcmprofileszyjtjid',
        },
      {
        name: 'n_yglx_eq',
        prop: 'n_yglx_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_pcmprofileszyjtjname_like',
        prop: 'n_pcmprofileszyjtjname_like',
        dataType: 'TEXT',
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