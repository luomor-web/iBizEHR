/**
 * GLGrid 部件模型
 *
 * @export
 * @class GLGridModel
 */
export default class GLGridModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof GLGridGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof GLGridGridMode
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
          name: 'bmid',
          prop: 'bmid',
          dataType: 'INHERIT',
        },
        {
          name: 'reason',
          prop: 'reason',
          dataType: 'TEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'pcmydntmxname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pcmydntmxid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'pcmydntmxid',
          dataType: 'GUID',
        },
        {
          name: 'sxrq',
          prop: 'sxrq',
          dataType: 'INHERIT',
        },
        {
          name: 'zzid',
          prop: 'zzid',
          dataType: 'INHERIT',
        },
        {
          name: 'zzdzs',
          prop: 'zzdzs',
          dataType: 'INHERIT',
        },
        {
          name: 'checkstatus',
          prop: 'checkstatus',
          dataType: 'INHERIT',
        },
        {
          name: 'lxdh',
          prop: 'lxdh',
          dataType: 'INHERIT',
        },
        {
          name: 'yzw',
          prop: 'yzw',
          dataType: 'INHERIT',
        },
        {
          name: 'shortname',
          prop: 'shortname',
          dataType: 'INHERIT',
        },
        {
          name: 'pimpersonname',
          prop: 'pimpersonname',
          dataType: 'INHERIT',
        },
        {
          name: 'pcmydntmx',
          prop: 'pcmydntmxid',
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