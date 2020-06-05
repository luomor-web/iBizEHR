/**
 * JDSQMXGR 部件模型
 *
 * @export
 * @class JDSQMXGRModel
 */
export default class JDSQMXGRModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof JDSQMXGRGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof JDSQMXGRGridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'orgsectorid',
          prop: 'orgsectorid',
          dataType: 'PICKUP',
        },
        {
          name: 'ormygw',
          prop: 'ormygw',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'ormyzw',
          prop: 'ormyzw',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'ormpostid',
          prop: 'ormpostid',
          dataType: 'PICKUP',
        },
        {
          name: 'pimdistirbutionid',
          prop: 'pimdistirbutionid',
          dataType: 'PICKUP',
        },
        {
          name: 'ormpostname',
          prop: 'ormpostname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'createdate',
          prop: 'createdate',
          dataType: 'DATETIME',
        },
        {
          name: 'finishdd',
          prop: 'finishdd',
          dataType: 'YESNO',
        },
        {
          name: 'srfmajortext',
          prop: 'pcmddsqdmxname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pcmddsqdmxid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'pcmddsqdmxid',
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
          dataType: 'PICKUPDATA',
        },
        {
          name: 'ormorgsectorname',
          prop: 'ormorgsectorname',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'jdkssj',
          prop: 'jdkssj',
          dataType: 'DATE',
        },
        {
          name: 'ormdutyid',
          prop: 'ormdutyid',
          dataType: 'PICKUP',
        },
        {
          name: 'orgid',
          prop: 'orgid',
          dataType: 'PICKUP',
        },
        {
          name: 'checkstatus',
          prop: 'checkstatus',
          dataType: 'SSCODELIST',
        },
        {
          name: 'orgname',
          prop: 'orgname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'jdjssj',
          prop: 'jdjssj',
          dataType: 'DATE',
        },
        {
          name: 'orgsectorname',
          prop: 'orgsectorname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'pcmddsqdid',
          prop: 'pcmddsqdid',
          dataType: 'PICKUP',
        },
        {
          name: 'pcmddsqdmx',
          prop: 'pcmddsqdmxid',
        },
      {
        name: 'n_ygbh_like',
        prop: 'n_ygbh_like',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'n_pimdistirbutionname_like',
        prop: 'n_pimdistirbutionname_like',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_checkstatus_eq',
        prop: 'n_checkstatus_eq',
        dataType: 'SSCODELIST',
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