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
          name: 'ygw',
          prop: 'ygw',
          dataType: 'INHERIT',
        },
        {
          name: 'ygbh',
          prop: 'ygbh',
          dataType: 'INHERIT',
        },
        {
          name: 'zz',
          prop: 'zz',
          dataType: 'INHERIT',
        },
        {
          name: 'jsrq',
          prop: 'jsrq',
          dataType: 'DATE',
        },
        {
          name: 'srfmajortext',
          prop: 'pcmydbxmxname',
          dataType: 'TEXT',
        },
        {
          name: 'sxrq',
          prop: 'sxrq',
          dataType: 'INHERIT',
        },
        {
          name: 'srfkey',
          prop: 'pcmydbxmxid',
          dataType: 'GUID',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pcmydbxmxid',
          dataType: 'GUID',
        },
        {
          name: 'lxdh',
          prop: 'lxdh',
          dataType: 'INHERIT',
        },
        {
          name: 'bm',
          prop: 'bm',
          dataType: 'INHERIT',
        },
        {
          name: 'yzw',
          prop: 'yzw',
          dataType: 'INHERIT',
        },
        {
          name: 'pimpersonname',
          prop: 'pimpersonname',
          dataType: 'INHERIT',
        },
        {
          name: 'bxyy',
          prop: 'bxyy',
          dataType: 'TEXT',
        },
        {
          name: 'pcmydbxmx',
          prop: 'pcmydbxmxid',
        },
      {
        name: 'n_ygbh_like',
        prop: 'n_ygbh_like',
        dataType: 'INHERIT',
      },
      {
        name: 'n_pimpersonname_like',
        prop: 'n_pimpersonname_like',
        dataType: 'INHERIT',
      },
      {
        name: 'n_zz_like',
        prop: 'n_zz_like',
        dataType: 'INHERIT',
      },
      {
        name: 'n_bm_like',
        prop: 'n_bm_like',
        dataType: 'INHERIT',
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