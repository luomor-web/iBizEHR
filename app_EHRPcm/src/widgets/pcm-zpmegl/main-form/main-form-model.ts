/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof MainModel
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
        prop: 'pcmzpmeglid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pcmzpmeglname',
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
        name: 'nd',
        prop: 'nd',
        dataType: 'TEXT',
      },
      {
        name: 'ormorgid',
        prop: 'ormorgid',
        dataType: 'PICKUP',
      },
      {
        name: 'ormorgname',
        prop: 'ormorgname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'xyzpame',
        prop: 'xyzpame',
        dataType: 'INT',
      },
      {
        name: 'ybdrs_xza',
        prop: 'ybdrs_xza',
        dataType: 'INT',
      },
      {
        name: 'sfce_xza',
        prop: 'sfce_xza',
        dataType: 'YESNO',
      },
      {
        name: 'xyzpbme',
        prop: 'xyzpbme',
        dataType: 'INT',
      },
      {
        name: 'ybdrs_xzb',
        prop: 'ybdrs_xzb',
        dataType: 'INT',
      },
      {
        name: 'sfce_xzb',
        prop: 'sfce_xzb',
        dataType: 'YESNO',
      },
      {
        name: 'xyzpxzyme',
        prop: 'xyzpxzyme',
        dataType: 'INT',
      },
      {
        name: 'ybdrs_xzxzy',
        prop: 'ybdrs_xzxzy',
        dataType: 'INT',
      },
      {
        name: 'sfce_xzxzy',
        prop: 'sfce_xzxzy',
        dataType: 'YESNO',
      },
      {
        name: 'shzpame',
        prop: 'shzpame',
        dataType: 'INT',
      },
      {
        name: 'ybdrs_sza',
        prop: 'ybdrs_sza',
        dataType: 'INT',
      },
      {
        name: 'sfce_sza',
        prop: 'sfce_sza',
        dataType: 'YESNO',
      },
      {
        name: 'shzpbme',
        prop: 'shzpbme',
        dataType: 'INT',
      },
      {
        name: 'ybdrs_szb',
        prop: 'ybdrs_szb',
        dataType: 'INT',
      },
      {
        name: 'sfce_szb',
        prop: 'sfce_szb',
        dataType: 'YESNO',
      },
      {
        name: 'shzpyme',
        prop: 'shzpyme',
        dataType: 'INT',
      },
      {
        name: 'ybdrs_szy',
        prop: 'ybdrs_szy',
        dataType: 'INT',
      },
      {
        name: 'sfce_szy',
        prop: 'sfce_szy',
        dataType: 'YESNO',
      },
      {
        name: 'shzpjhwme',
        prop: 'shzpjhwme',
        dataType: 'INT',
      },
      {
        name: 'ybdrs_szjhw',
        prop: 'ybdrs_szjhw',
        dataType: 'INT',
      },
      {
        name: 'sfce_szjhw',
        prop: 'sfce_szjhw',
        dataType: 'YESNO',
      },
      {
        name: 'pcmzpmeglid',
        prop: 'pcmzpmeglid',
        dataType: 'GUID',
      },
      {
        name: 'pcmzpmegl',
        prop: 'pcmzpmeglid',
        dataType: 'FONTKEY',
      },
    ]
  }

}