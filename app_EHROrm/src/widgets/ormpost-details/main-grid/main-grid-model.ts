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
          name: 'ormpostlibname',
          prop: 'ormpostlibname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'ormpostid',
          prop: 'ormpostid',
          dataType: 'PICKUP',
        },
        {
          name: 'gwflag',
          prop: 'gwflag',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'createdate',
          prop: 'createdate',
          dataType: 'DATETIME',
        },
        {
          name: 'ormpostlibid',
          prop: 'ormpostlibid',
          dataType: 'PICKUP',
        },
        {
          name: 'isconfidential',
          prop: 'isconfidential',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'srfmajortext',
          prop: 'ormpostdetailsname',
          dataType: 'TEXT',
        },
        {
          name: 'mustexcyear',
          prop: 'mustexcyear',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'srfkey',
          prop: 'ormpostdetailsid',
          dataType: 'GUID',
        },
        {
          name: 'srfdataaccaction',
          prop: 'ormpostdetailsid',
          dataType: 'GUID',
        },
        {
          name: 'gwtype',
          prop: 'gwtype',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'sugexcyear',
          prop: 'sugexcyear',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'postnature',
          prop: 'postnature',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'createman',
          prop: 'createman',
          dataType: 'TEXT',
        },
        {
          name: 'ormpostdetails',
          prop: 'ormpostdetailsid',
        },
      {
        name: 'n_ormpostdetailsname_like',
        prop: 'n_ormpostdetailsname_like',
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