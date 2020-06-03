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
          name: 'pcmydjdmxid',
          prop: 'pcmydjdmxid',
          dataType: 'GUID',
        },
        {
          name: 'ygbh',
          prop: 'ygbh',
          dataType: 'INHERIT',
        },
        {
          name: 'pimdistirbutionid',
          prop: 'pimdistirbutionid',
          dataType: 'PICKUP',
        },
        {
          name: 'ormpostid',
          prop: 'ormpostid',
          dataType: 'PICKUP',
        },
        {
          name: 'ormorgsectorid',
          prop: 'ormorgsectorid',
          dataType: 'PICKUP',
        },
        {
          name: 'ormpostname',
          prop: 'ormpostname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'ormorgid',
          prop: 'ormorgid',
          dataType: 'PICKUP',
        },
        {
          name: 'zz',
          prop: 'zz',
          dataType: 'INHERIT',
        },
        {
          name: 'jdksrq',
          prop: 'jdksrq',
          dataType: 'DATE',
        },
        {
          name: 'srfmajortext',
          prop: 'pcmydjdmxname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pcmydjdmxid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'pcmydjdmxid',
          dataType: 'GUID',
        },
        {
          name: 'ormdutyname',
          prop: 'ormdutyname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'ormorgname',
          prop: 'ormorgname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'ormorgsectorname',
          prop: 'ormorgsectorname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'jdjsrq',
          prop: 'jdjsrq',
          dataType: 'DATE',
        },
        {
          name: 'ormdutyid',
          prop: 'ormdutyid',
          dataType: 'PICKUP',
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
          name: 'pcmydjdmx',
          prop: 'pcmydjdmxid',
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
        name: 'n_ormorgname_like',
        prop: 'n_ormorgname_like',
        dataType: 'PICKUPTEXT',
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