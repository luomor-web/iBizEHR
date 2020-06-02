/**
 * GZRGrid 部件模型
 *
 * @export
 * @class GZRGridModel
 */
export default class GZRGridModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof GZRGridGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof GZRGridGridMode
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
          name: 'wwzzid',
          prop: 'wwzzid',
          dataType: 'TEXT',
        },
        {
          name: 'jsrq',
          prop: 'jsrq',
          dataType: 'DATE',
        },
        {
          name: 'srfmstag',
        },
        {
          name: 'srfmajortext',
          prop: 'pcmydgzmxname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pcmydgzmxid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'pcmydgzmxid',
          dataType: 'GUID',
        },
        {
          name: 'ksrq',
          prop: 'ksrq',
          dataType: 'DATE',
        },
        {
          name: 'wbbm',
          prop: 'wbbm',
          dataType: 'TEXT',
        },
        {
          name: 'wbgw',
          prop: 'wbgw',
          dataType: 'TEXT',
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
          name: 'wbzw',
          prop: 'wbzw',
          dataType: 'TEXT',
        },
        {
          name: 'wbzz',
          prop: 'wbzz',
          dataType: 'TEXT',
        },
        {
          name: 'pimpersonname',
          prop: 'pimpersonname',
          dataType: 'INHERIT',
        },
        {
          name: 'pcmydgzmx',
          prop: 'pcmydgzmxid',
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
        name: 'n_wbzz_like',
        prop: 'n_wbzz_like',
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