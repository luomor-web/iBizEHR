/**
 * Main_2 部件模型
 *
 * @export
 * @class Main_2Model
 */
export default class Main_2Model {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof Main_2Model
  */
  public getDataItems(): any[] {
    return [
      {
        name: 'srfwfmemo',
        prop: 'srfwfmemo',
        dataType: 'TEXT',
      },
      // 前端新增修改标识，新增为"0",修改为"1"或未设值
      {
        name: 'srffrontuf',
        prop: 'srffrontuf',
        dataType: 'TEXT',
      },
      {
        name: 'srfupdatedate',
        prop: 'updatedate',
        dataType: 'DATETIME',
      },
      {
        name: 'srforikey',
      },
      {
        name: 'srfkey',
        prop: 'trmtrainteacherid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'trmtrainteachername',
        dataType: 'TEXT',
      },
      {
        name: 'srftempmode',
      },
      {
        name: 'srfuf',
      },
      {
        name: 'srfdeid',
      },
      {
        name: 'srfsourcekey',
      },
      {
        name: 'pimpersonname',
        prop: 'pimpersonname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'jslx',
        prop: 'jslx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'dj',
        prop: 'dj',
        dataType: 'TEXT',
      },
      {
        name: 'zjhm',
        prop: 'zjhm',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'xb',
        prop: 'xb',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'nl',
        prop: 'nl',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'lxdh',
        prop: 'lxdh',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'trmtrainagencyname',
        prop: 'trmtrainagencyname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'jglb',
        prop: 'jglb',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'zjkssj',
        prop: 'zjkssj',
        dataType: 'DATE',
      },
      {
        name: 'jf',
        prop: 'jf',
        dataType: 'FLOAT',
      },
      {
        name: 'sfgx',
        prop: 'sfgx',
        dataType: 'YESNO',
      },
      {
        name: 'ormorgname',
        prop: 'ormorgname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'zp',
        prop: 'zp',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'bz',
        prop: 'bz',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'trmtrainagencyid',
        prop: 'trmtrainagencyid',
        dataType: 'PICKUP',
      },
      {
        name: 'pj',
        prop: 'pj',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'trmtrainteacherid',
        prop: 'trmtrainteacherid',
        dataType: 'GUID',
      },
      {
        name: 'ormorgid',
        prop: 'ormorgid',
        dataType: 'PICKUP',
      },
      {
        name: 'trmtrainteacher',
        prop: 'trmtrainteacherid',
        dataType: 'FONTKEY',
      },
    ]
  }

}